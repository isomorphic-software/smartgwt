package com.smartgwt.sample.showcase.client.basics.interaction;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class BasicCustomTabOrderSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Click a button to give it keyboard focus and use Tab and Shift+Tab keys to move"
    		+ "focus through the buttons. Now use the select item to modify the tabbing order.</p>"
    		+ "<p>Smart GWT provides simple APIs to manage the tab position of specific components "
    		+ "while maintaining automatic tabIndex management for the application as a whole.</p>"; 

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
        	BasicCustomTabOrderSample panel = new BasicCustomTabOrderSample();
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
    
    // Helper class for the focusable buttons with a notion of which row/col they belong to
    private class InnerButton extends IButton {
    	private int rowNum;
    	public void setRowNum(int rowNum) {
    		this.rowNum = rowNum;
    	}
    	public int getRowNum() {
    		return this.rowNum;
    	}
    	
    	private int colNum;
    	public void setColNum(int colNum) {
    		this.colNum = colNum;
    	}
    	public int getColNum() {
    		return this.colNum;
    	}
    	InnerButton (String title, int rowNum, int colNum, String snapTo, int snapOffsetLeft, int snapOffsetTop) {
    		setTitle(title);
    		setRowNum(rowNum);
    		setColNum(colNum);
    		setSnapTo(snapTo);
    		setSnapOffsetLeft(snapOffsetLeft);
    		setSnapOffsetTop(snapOffsetTop);
    	}
    	
    }
    
    // Logic to handle updating tab sequence at run time, to tab horizontally or
    // vertically through the buttons
    private boolean verticalTabbing;

    private void updateTabDirection(boolean verticalTabbing, InnerButton[] buttons) {
    	if (this.verticalTabbing == verticalTabbing) return;
    	this.verticalTabbing = verticalTabbing;
    	for (int i =0; i < buttons.length; i++) {
    		InnerButton b = buttons[i];
    		int relativeTabPosition;
    		if (verticalTabbing) {
    			relativeTabPosition = b.getRowNum() + (2*b.getColNum());
    		} else {
    			relativeTabPosition = (2*b.getRowNum()) + b.getColNum();    			
    		}
    		b.setRelativeTabPosition(relativeTabPosition);
    	}
    	
    }

    public Canvas getViewPanel() {
    	Canvas customTabSequence = new Canvas();
    	customTabSequence.setHeight(140);
    	customTabSequence.setIsGroup(true);
    	customTabSequence.setMargin(5);
    	customTabSequence.setGroupTitle("Custom Tab Sequence");
    	
    	final InnerButton[] buttons = {
    			new InnerButton("First Child", 0,0, "TL", 10,10),
    			new InnerButton("Second Child", 1,0, "BL", 10,-10),
    			new InnerButton("Third Child", 0,1, "TR", -10,10),
    			new InnerButton("Fourth Child", 1,1, "BR", -10,-10)
    	};

    	
    	customTabSequence.setChildren(buttons);
    	customTabSequence.draw();
    	
    	
    	// Default tab behavior is to move through children in child-order
    	// this matches "vertical" tabbing as the children have been added to the parent in columns
    	verticalTabbing = true;
    	
    	DynamicForm form = new DynamicForm();
    	form.setColWidths("*", "*");
    	
    	SelectItem directionItem = new SelectItem("direction", "Select Tab Direction");
    	directionItem.setWrapTitle(false);
    	directionItem.setValueMap("Vertical", "Horizontal");
    	directionItem.setDefaultValue("Vertical");
    	
    	directionItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				String value = (String)event.getValue();
				updateTabDirection("Vertical".equals(value), buttons);
			}
		});
    	form.setItems(directionItem);
    	
        VLayout vLayout = new VLayout();
        vLayout.setWidth(320);
        vLayout.addMember(form);
        vLayout.addMember(customTabSequence);

        return vLayout;

    }

    public String getIntro() {
        return DESCRIPTION;
    }
}