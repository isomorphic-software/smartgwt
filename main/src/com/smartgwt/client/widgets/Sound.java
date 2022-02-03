/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
package com.smartgwt.client.widgets;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process
import com.smartgwt.client.util.tour.*;

import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.ace.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;
import com.smartgwt.logicalstructure.widgets.tour.*;

/**
 * Smart GWT class for loading and playing audio files using the HTML5 &lt;AUDIO&gt;  element.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Sound")
public class Sound extends BaseWidget implements com.smartgwt.client.widgets.data.events.HasTimeChangedHandlers {

    public static Sound getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Sound(jsObj);
        } else {
            assert refInstance instanceof Sound;
            return (Sound)refInstance;
        }
    }
        


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Sound.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Sound.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Sound.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Sound.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Sound(){
        scClassName = "Sound";
    }

    public Sound(JavaScriptObject jsObj){
        scClassName = "Sound";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Should the specified {@link com.smartgwt.client.widgets.Sound#getSrc audio file} be loaded automatically. <P> If set to
     * <code>false</code> developers may load the audio explicitly via  {@link com.smartgwt.client.widgets.Sound#load load()}
     *
     * @param autoLoad New autoLoad value. Default value is false
     * @return {@link com.smartgwt.client.widgets.Sound Sound} instance, for chaining setter calls
     */
    public Sound setAutoLoad(boolean autoLoad) {
        return (Sound)setAttribute("autoLoad", autoLoad, true);
    }

    /**
     * Should the specified {@link com.smartgwt.client.widgets.Sound#getSrc audio file} be loaded automatically. <P> If set to
     * <code>false</code> developers may load the audio explicitly via  {@link com.smartgwt.client.widgets.Sound#load load()}
     *
     * @return Current autoLoad value. Default value is false
     */
    public boolean getAutoLoad()  {
        Boolean result = getAttributeAsBoolean("autoLoad");
        return result == null ? false : result;
    }
    

    /**
     * Should the specified {@link com.smartgwt.client.widgets.Sound#getSrc audio file} be played automatically? <P> If set to
     * <code>false</code> developers may play the audio explicitly via  {@link com.smartgwt.client.widgets.Sound#play play()}.
     *
     * @param autoPlay New autoPlay value. Default value is false
     * @return {@link com.smartgwt.client.widgets.Sound Sound} instance, for chaining setter calls
     */
    public Sound setAutoPlay(boolean autoPlay) {
        return (Sound)setAttribute("autoPlay", autoPlay, true);
    }

    /**
     * Should the specified {@link com.smartgwt.client.widgets.Sound#getSrc audio file} be played automatically? <P> If set to
     * <code>false</code> developers may play the audio explicitly via  {@link com.smartgwt.client.widgets.Sound#play play()}.
     *
     * @return Current autoPlay value. Default value is false
     */
    public boolean getAutoPlay()  {
        Boolean result = getAttributeAsBoolean("autoPlay");
        return result == null ? false : result;
    }
    

    /**
     * URL of the audio file to be played by this sound instance. If multiple file URLs are supplied, the browser will make use
     * of the first file type for which it has support.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the {@link com.smartgwt.client.widgets.Sound#getSrc src} of this sound instance at runtime. Note that  {@link com.smartgwt.client.widgets.Sound#getAutoLoad autoLoad} and {@link com.smartgwt.client.widgets.Sound#getAutoPlay autoPlay} govern whether this media will be loaded or played immediately when the src value is changed.
     *
     * @param src URL of new audio file to be played by this sound instance. Default value is null
     * @return {@link com.smartgwt.client.widgets.Sound Sound} instance, for chaining setter calls
     */
    public Sound setSrc(String src) {
        return (Sound)setAttribute("src", src, true);
    }

    /**
     * URL of the audio file to be played by this sound instance. If multiple file URLs are supplied, the browser will make use
     * of the first file type for which it has support.
     *
     * @return Current src value. Default value is null
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }

    /**
     * URL of the audio file to be played by this sound instance. If multiple file URLs are supplied, the browser will make use
     * of the first file type for which it has support.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the {@link com.smartgwt.client.widgets.Sound#getSrc src} of this sound instance at runtime. Note that  {@link com.smartgwt.client.widgets.Sound#getAutoLoad autoLoad} and {@link com.smartgwt.client.widgets.Sound#getAutoPlay autoPlay} govern whether this media will be loaded or played immediately when the src value is changed.
     *
     * @param src URL of new audio file to be played by this sound instance. Default value is null
     * @return {@link com.smartgwt.client.widgets.Sound Sound} instance, for chaining setter calls
     */
    public Sound setSrc(String... src) {
        return (Sound)setAttribute("src", src, true);
    }

    /**
     * URL of the audio file to be played by this sound instance. If multiple file URLs are supplied, the browser will make use
     * of the first file type for which it has support.
     *
     * @return Current src value. Default value is null
     */
    public String[] getSrcAsStringArray()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("src"));
    }
    

    // ********************* Methods ***********************
	/**
     * Retrieves the current playback time of a playing or paused audio file in seconds.
     *
     * @return current playback time audio file in seconds. If the   file has not been loaded, or no {@link
     * com.smartgwt.client.widgets.Sound#getSrc src} is defined, this method will   return zero.
     */
    public native Double getCurrentTime() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCurrentTime", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCurrentTime();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDouble(D)(ret);
    }-*/;

	/**
     * Retrieves the duration of the current audio file in seconds.
     *
     * @return duration of the audio file in seconds. If the   file has not been loaded, or no {@link
     * com.smartgwt.client.widgets.Sound#getSrc src} is defined, this method will   return null.
     */
    public native Double getDuration() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDuration", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDuration();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDouble(D)(ret);
    }-*/;

	/**
     * This method will cause the {@link com.smartgwt.client.widgets.Sound#getSrc specified audio file} to be loaded
     */
    public native void load() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "load", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.load();
    }-*/;

	/**
     * This method will cause the {@link com.smartgwt.client.widgets.Sound#getSrc specified audio file} to be loaded
     * @param canPlayCallback notification to fire when the file is ready to play
     */
    public native void load(CanPlayCallback canPlayCallback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "load", "CanPlayCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.load(
			$entry( function() { 
				if(canPlayCallback!=null) canPlayCallback.@com.smartgwt.client.callbacks.CanPlayCallback::execute()(
				);
			}));
    }-*/;
	
	/**
     * Pause playback of the audio file.
     */
    public native void pause() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "pause", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.pause();
    }-*/;

	/**
     * If playback is currently paused, reset the playback position to the start of the audio file so a call to {@link
     * com.smartgwt.client.widgets.Sound#play play()} will play from the start, rather than resuming playback from the current
     * position.
     */
    public native void reset() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reset", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reset();
    }-*/;

	/**
     * Move playback to a particular time in a loaded audio file.
     * @param time time to move to. This method will have no effect if the  file has not been loaded or no {@link
     * com.smartgwt.client.widgets.Sound#getSrc src} element is defined.
     */
    public native void setCurrentTime(Double time) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setCurrentTime", "Double");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setCurrentTime(time == null ? null : time.@java.lang.Double::doubleValue()());
    }-*/;

    /**
     * Add a timeChanged handler.
     * <p>
     * Notification method fired repeatedly to indicate a change in currentTime value while an audio file is playing.
     *
     * @param handler the timeChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTimeChangedHandler(com.smartgwt.client.widgets.data.events.TimeChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.data.events.TimeChangedEvent.getType()) == 0) setupTimeChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.data.events.TimeChangedEvent.getType());
    }

    private native void setupTimeChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var timeChanged = $entry(function(){
            var param = {"_this": this, "currentTime" : arguments[0]};
            var event = @com.smartgwt.client.widgets.data.events.TimeChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.Sound::handleTearDownTimeChangedEvent()();
            if (hasDefaultHandler) this.Super("timeChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("timeChanged"));
            obj.addProperties({timeChanged:  timeChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("timeChanged"));
            obj.timeChanged =  timeChanged             ;
        }
    }-*/;

    private void handleTearDownTimeChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.data.events.TimeChangedEvent.getType()) == 0) tearDownTimeChangedEvent();
    }

    private native void tearDownTimeChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("timeChanged")) delete obj.timeChanged;
    }-*/;


    // ********************* Static Methods ***********************

	/**
     * Returns true for browsers which natively support HTML5 Audio, used by the Sound class
     *
     * @return true if Audio is supported in this browser
     */
    public static native boolean isSupported() /*-{
        var ret = $wnd.isc.Sound.isSupported();
        return ret == null ? false : ret;
    }-*/;



    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param soundProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Sound soundProperties) /*-{
        if (soundProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Sound.@java.lang.Object::getClass()(), "setDefaultProperties", soundProperties.@java.lang.Object::getClass()());
        }
        soundProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = soundProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Sound.addProperties(properties);
    }-*/;

    // ***********************************************************



   /**
    * Play the audio file. If necessary the file will be loaded first.
    *
    */
    public native void play() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.play();
    }-*/;

   /**
    * Play the audio file. If necessary the file will be loaded first.
    *
    * @param playbackCompleteCallback notification fired when playback completes.
    *
    */
    public native void play(PlaybackCompleteCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.play(
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.PlaybackCompleteCallback::execute()();
			}));
    }-*/;

   /**
    * Convenience method to load and play a specified audio file.
    * <P>
    * For more explicit control over loading and playback of audio files, developers may
    * create an instance of Sound and call methods directly on that object.
    *
    * @param src URL of the audio clip to play.
    *
    */
    public static native void play(String src) /*-{
        $wnd.isc.Sound.play(src);
    }-*/;
    
   /**
    * Convenience method to load and play a specified audio file.
    * <P>
    * For more explicit control over loading and playback of audio files, developers may
    * create an instance of Sound and call methods directly on that object.
    *
    * @param src URL of the audio clip to play.
    * @param callback callback to execute when the clip playback completes.
    *
    */
    public static native void play(String src, PlaybackCompleteCallback callback) /*-{
        $wnd.isc.Sound.play(src, 
            $entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.PlaybackCompleteCallback::execute()();
			}));
    }-*/;

    /**
     * See {@link #getSrcAsStringArray}.
     * @deprecated in favor of {@link #getSrcAsStringArray}.
     */
    public String[] getSrcAsString()  {
        return getSrcAsStringArray();
    }


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(SoundLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.autoLoad = getAttributeAsString("autoLoad");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Sound.autoLoad:" + t.getMessage() + "\n";
        }
        try {
            s.autoPlay = getAttributeAsString("autoPlay");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Sound.autoPlay:" + t.getMessage() + "\n";
        }
        try {
            s.srcAsString = getAttributeAsString("src");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Sound.srcAsString:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        SoundLogicalStructure s = new SoundLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
