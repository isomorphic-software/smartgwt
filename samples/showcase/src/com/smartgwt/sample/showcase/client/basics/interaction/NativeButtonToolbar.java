package com.smartgwt.sample.showcase.client.basics.interaction;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.smartgwt.client.callbacks.ShiftFocusCallback;
import com.smartgwt.client.callbacks.TabIndexUpdatedCallback;
import com.smartgwt.client.util.EventHandler;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.TabIndexManager;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;

/**
 * Custom component to hold some native HTML elements which integrate intuitively into the page's tab order
 */
public class NativeButtonToolbar extends Canvas {
	
	
	NativeButtonToolbar (String... buttonTitles) {
		
		this.setHeight(50); // default height
		
		NativeButtonConfig[] buttons = new NativeButtonConfig[buttonTitles.length];
		for (int i =0; i < buttonTitles.length; i++) {
			buttons[i] = new NativeButtonConfig(buttonTitles[i]);
		}
		setButtons(buttons);
		
	}
	
	private boolean registeredTabIndices = false;
	public void registerButtonTabIndices() {
		
		// (Demo code only: Doesn't handle buttons being modified after registration)
		if (registeredTabIndices) return;
		
        for (int i = 0; i < this.buttons.length; i++) {
            NativeButtonConfig button = this.buttons[i];
            
            TabIndexManager.addTarget(
                // arbitrary identifier for the button (must be unique within the page)
                this.getButtonElementID(button),
                // this entry will be focusable
                true,
                // parent for the new entry in the TabIndexManager tree.
                // By passing in our own ID we ensure the new buttons' entries
                // are stored under this widget's entry in the TabIndexManager tree.
                // This means this widget is moved to a new tab-position on the page
                // the buttons will be moved with it.
                this.getID(),
                // No need for an explicit position - we are adding the buttons
                // in the order in which they appear in the buttons array
                null,
                // Callback to fire if changes to the page structure cause
                // a new numeric tab-index to be generated for the button.
                // We can use this to update the DOM with the new value
                new TabIndexUpdatedCallback() {
					
					@Override
					public void execute(String ID) {
						updateButtonTabIndex(ID);
						
					}
				},
                //{target:this, methodName:"updateButtonTabIndex"},
                // Callback to focus in this button programmatically
                // This method will be fired when TabIndexManager APIs to shift
                // focus are invoked, for example when the user is tabbing through
                // a page while the clickmask is up
                new ShiftFocusCallback() {
					
					@Override
					public boolean execute(String ID) {
						return focusInButton(ID);
					}
				}
            );
        }	
		
		registeredTabIndices = true;
	}

	// Notification fired by the TabIndexManager when the numeric tabIndex for a button
	// changes due to (for example) the page being restructured
	// Use this to update the DOM element
	public void updateButtonTabIndex(String buttonID) {

        if (!this.isDrawn()) return;
        
        
        // We use the buttonID as the DOM element ID, so we can simply look for the
        // appropriate element in the DOM
        Element element = DOM.getElementById(buttonID);

        if (element != null) {
	        // set the native tabIndex of the DOM element to the new numeric value
	        // supplied by the TabIndexManager
	        element.setTabIndex(TabIndexManager.getTabIndex(buttonID));
        }
    }
	
	// Callback to programmatically shift focus to one of our buttons
    public boolean focusInButton (String buttonID) {
        // Skip this if we're undrawn or masked
        if (!this.isDrawn() || EventHandler.targetIsMasked(this)) return false;
        
        // We use the buttonID as the DOM element ID, so we can simply look for the
        // appropriate element in the DOM
    	Element element = DOM.getElementById(buttonID);
    	// call 'focus()' to shift native keyboard focus to the element
        if (element != null) {
        	element.focus();
        	return true;
        }
        return false;
	}
    
	@Override
	public String getInnerHTML() {

		// Lazily ensure we have entries in the TabIndexManager for our button elements
		registerButtonTabIndices();

	    // Custom contents for this component: Write out native HTML button elements for
	    // each of our specified "button" configurations
	    String html = "<table border=1 cellPadding=5><tr>";
        for (int i = 0; i < this.buttons.length; i++) {
            NativeButtonConfig button = this.buttons[i];
            
            html+= "<td><button type='button'" +
                    // Unique ID for the DOM element
                    " id='" + this.getButtonElementID(button) +
                    // Numeric tabIndex supplied by the TabIndexManager
                    "' tabindex=" +  
                        TabIndexManager.getTabIndex(this.getButtonElementID(button))
                    + ">" +
                    button.getTitle() + 
                    "</button></td>";
        }
        html += "</tr></table>";     
SC.logWarn("OK - getInnerHTML:" + html);        
        return html;
	}

    // Helper to get arbitrary unique ID for each button
    // This is used as the ID for the DOM element, and a the unique identifier for
    // the button within the TabIndexManager
    private String getButtonElementID (NativeButtonConfig button) {
    	int index = java.util.Arrays.asList(buttons).indexOf(button);
        return this.getID() + "_buttonElement_" + index;
    }

	private NativeButtonConfig[] buttons;

	public NativeButtonConfig[] getButtons() {
		return buttons;
	}

	public void setButtons(NativeButtonConfig[] buttons) {
		this.buttons = buttons;
	}
	
    @Override
    public void destroy() {
    	// When this widget is destroyed, remove the obsolete entries from the TabIndexManager
	    for (int i = 0; i < this.buttons.length; i++) {
            TabIndexManager.removeTarget(this.getButtonElementID(this.buttons[i]));
        }
        super.destroy();
    }	

}
