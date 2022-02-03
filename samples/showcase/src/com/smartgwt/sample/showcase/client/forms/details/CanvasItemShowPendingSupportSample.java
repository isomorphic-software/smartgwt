package com.smartgwt.sample.showcase.client.forms.details;

import com.smartgwt.client.core.KeyIdentifier;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CanvasItem;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Progressbar;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.form.fields.events.ShowValueEvent;
import com.smartgwt.client.widgets.form.fields.events.ShowValueHandler;
import com.smartgwt.client.widgets.form.fields.events.CanEditChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.CanEditChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.PendingStatusChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.PendingStatusChangedHandler;
import com.smartgwt.client.util.EventHandler;

import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class CanvasItemShowPendingSupportSample extends ShowcasePanel {
    private static final String DESCRIPTION = "CanvasItems can utilize the pendingStatusChanged() "+
        "notification method to update their appearance when the pending visual state should be shown "+
        "or cleared. <p>"+
        "The following example is an implementation of a progressbar CanvasItem that can be clicked to "+
        "change the value. The custom pending visual state is for the progressbar label to be bold.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
        	CanvasItemShowPendingSupportSample panel = new CanvasItemShowPendingSupportSample();
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

    public class ProgressbarDefault extends Progressbar {
    	
        public ProgressbarDefault() {
        }
    	
        public void _storeValue(int newPercentDone) {
            this.setTitle("Project progress: " + newPercentDone + "%");
            this.setPercentDone(newPercentDone);
            CanvasItem canvasItem = this.getCanvasItem();
            canvasItem.storeValue(newPercentDone);
        }
    }
    
    public class MyProgressbarItem extends CanvasItem {
        public MyProgressbarItem() {
            final ProgressbarDefault myProgressbarProperties = new ProgressbarDefault();
            myProgressbarProperties.setID("progressbarDefault");
            myProgressbarProperties.setCanFocus(true);
            myProgressbarProperties.setLength(160);
            myProgressbarProperties.setCursor(Cursor.POINTER);
            myProgressbarProperties.setShowTitle(true);
            myProgressbarProperties.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    float offsetX = myProgressbarProperties.getOffsetX();
                    int newPercentDone = Math.round(offsetX / myProgressbarProperties.getVisibleWidth() * 100);
                    newPercentDone = Math.max(0, Math.min(newPercentDone, 100));
                    myProgressbarProperties._storeValue(newPercentDone);
                }
            });
            myProgressbarProperties.addKeyPressHandler(new KeyPressHandler() {
                @Override
                public void onKeyPress(KeyPressEvent event) {
                    // http://www.w3.org/TR/wai-aria-practices/#slider
                    String keyName = EventHandler.getKey();
                    if (keyName.equalsIgnoreCase("Arrow_Right") ||
                        keyName.equalsIgnoreCase("Arrow_Up"))
                    {
                        int currentPercentDone = myProgressbarProperties.getPercentDone();
                        if (currentPercentDone < 100) myProgressbarProperties._storeValue(currentPercentDone + 1);

                    } else if (keyName.equalsIgnoreCase("Arrow_Left") ||
                               keyName.equalsIgnoreCase("Arrow_Down"))
                    {
                        int currentPercentDone = myProgressbarProperties.getPercentDone();
                        if (currentPercentDone > 0) myProgressbarProperties._storeValue(currentPercentDone - 1);

                    } else if (keyName.equalsIgnoreCase("Home")) {
                        if (myProgressbarProperties.getPercentDone() != 0) myProgressbarProperties._storeValue(0);

                    } else if (keyName.equalsIgnoreCase("End")) {
                        if (myProgressbarProperties.getPercentDone() != 100) myProgressbarProperties._storeValue(100);
                    }
                }
            });
            this.setAriaRole("progressbar");
            this.setCanvas(myProgressbarProperties);
        }

    }   
    
    public Canvas getViewPanel() {
        final MyProgressbarItem canvasItem = new MyProgressbarItem();
        canvasItem.addCanEditChangedHandler(new CanEditChangedHandler() {
            @Override
            public void onCanEditChanged(CanEditChangedEvent event) {
                ProgressbarDefault p = (ProgressbarDefault)canvasItem.getCanvas();
                p.setProperty("ariaRole", event.getCanEdit() ? "slider" : "progressbar");
            }
        });
        canvasItem.addPendingStatusChangedHandler(new PendingStatusChangedHandler() {
            @Override
            public void onPendingStatusChanged(PendingStatusChangedEvent event) {
                ProgressbarDefault p = (ProgressbarDefault)canvasItem.getCanvas();
                p.setTitleStyle(event.getPendingStatus() ? "myProgressbarItemTitlePending" 
                                                            : "myProgressbarItemTitle");
            }
        });
        canvasItem.addShowValueHandler(new ShowValueHandler() {
            @Override
            public void onShowValue(ShowValueEvent event) {
                ProgressbarDefault p = (ProgressbarDefault)canvasItem.getCanvas();
                p.setTitle("Project progress: " + event.getDisplayValue() + "%");
                p.setPercentDone(Integer.parseInt((String)event.getDisplayValue()));
            }
        });
        canvasItem.setTitle("Click to set progress");
        canvasItem.setHeight(25);
        canvasItem.setShouldSaveValue(true);
        canvasItem.setShowPending(true);
        canvasItem.setValue(75);
		
        final DynamicForm form = new DynamicForm();
        form.setWidth(500);
        form.setColWidths(150, "*");
        KeyIdentifier key = new KeyIdentifier();
        key.setKeyName("Escape");
        form.setRevertValueKey(key);
		
        ButtonItem buttonItem = new ButtonItem();
        buttonItem.setTitle("Remember Current Value");
        buttonItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
            @Override
            public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
                form.rememberValues();
            }
        });
		
        form.setFields(canvasItem, buttonItem);
		
        HStack hStack = new HStack();
        hStack.setWidth100();
        hStack.setMembersMargin(20);
        hStack.addMember(form);
		
        return hStack;
    }
    
    public String getIntro() {
        return DESCRIPTION;
    }
}