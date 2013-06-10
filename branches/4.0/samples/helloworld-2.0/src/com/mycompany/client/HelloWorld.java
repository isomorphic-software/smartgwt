package com.mycompany.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.util.SC;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HelloWorld implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		IButton button = new IButton("Hello World");
		button.addClickHandler(new ClickHandler() {
							   public void onClick(ClickEvent event) {
							   SC.say("Hello World from SmartGWT");
							   }
							   });
		
		button.draw();
		
		//or
		//RootPanel.get().add(button);
	}
}