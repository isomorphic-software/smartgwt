package com.smartgwt.sample.showcase.client.basics.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.FocusChangedEvent;
import com.smartgwt.client.widgets.events.FocusChangedHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.CanvasItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItemIcon;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.SourceEntity;

public class CustomComponentTabOrderSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Arbitrary HTML or third party widgets can be included in the page's "
    		+ "tab order via APIs on the special TabIndexManager class. This sample demonstrates the inclusion of "
    		+ "some native HTML &lt;button&gt; elements. These native elements are present in the page's tab "
    		+ "order at the expected position, and are updated automatically when the structure of the page is "
    		+ "changed via the 'Switch Members' button.";


    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
        	CustomComponentTabOrderSample panel = new CustomComponentTabOrderSample();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }
    
    public Canvas getViewPanel() {
    	

    	// Demo of custom component in standard page UI
    	final HLayout outerLayout = new HLayout();
    	outerLayout.setMembersMargin(10);
    	outerLayout.setHeight(250);

    	VLayout customTabLayout = new VLayout();
    	customTabLayout.setWidth(250);
    	customTabLayout.setIsGroup(true);
    	customTabLayout.setGroupTitle("Custom Tab Elements");
    	customTabLayout.setDefaultLayoutAlign(Alignment.CENTER);
    	customTabLayout.setLayoutMargin(10);
    	customTabLayout.setMembersMargin(5);
    	
    	IButton prevButton = new IButton("Previous SGWT Button");
    	prevButton.setWidth(200);
    	
    	// Example of the new NativeButtonToolbar class (has focusable native HTML elements)
    	NativeButtonToolbar toolbar1 = new NativeButtonToolbar("Native Button 1", "Native Button 2");
    	
    	IButton nextButton = new IButton("Subsequent SGWT Button");
    	nextButton.setWidth(200);
    	
    	customTabLayout.setMembers(prevButton, toolbar1, nextButton);
    	

        // Demo of this custom component embedded in a DynamicForm
    	DynamicForm customTabForm = new DynamicForm();
    	customTabForm.setWidth(250);
    	customTabForm.setIsGroup(true);
    	customTabForm.setGroupTitle("Custom Tab Form");
    	customTabForm.setPadding(5);
    	
    	// Create a canvasItem containing a NativeButtonToolbar
    	// (has focusable native HTML elements)
    	CanvasItem toolbarItem = new CanvasItem("custom","Native Toolbar");
    	toolbarItem.setCanvas(new NativeButtonToolbar("Native Button 1", "Native Button 2"));
    	
    	customTabForm.setItems(
    		new TextItem("item1"),
    		new TextItem("item2") {
    			// add some arbitrary icons to make the tab order more complex
    			{setIcons(new FormItemIcon(), new FormItemIcon());}
    		},
    		new ButtonItem("item3"),
    		
    		// This is the custom NativeButtonToolbar-based canvasItem
    		toolbarItem,
    		
    		new ButtonItem("item4"),
    		new TextItem("item5")
    	);
    	
    	outerLayout.setMembers(customTabLayout, customTabForm);

    	IButton switchMembersButton = new IButton("Switch Members");
    	switchMembersButton.setWidth(150);
    	switchMembersButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				outerLayout.reorderMember(1, 0);
				
			}
		});

        VLayout vLayout = new VLayout();
        vLayout.setMembersMargin(10);
        vLayout.addMember(outerLayout);
        vLayout.addMember(switchMembersButton);

        return vLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
    
    @Override
    public SourceEntity[] getSourceUrls() {
        return new SourceEntity[] {
                new SourceEntity("CustomComponentTabOrderSample.java", "source/basics/interaction/CustomComponentTabOrderSample.java.html"),
                new SourceEntity("NativeButtonToolbar.java", "source/basics/interaction/NativeButtonToolbar.java.html"),
                new SourceEntity("NativeButtonConfig.java", "source/basics/interaction/NativeButtonConfig.java.html")
        };
    }


}